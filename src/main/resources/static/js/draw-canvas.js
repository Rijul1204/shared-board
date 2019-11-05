var stompClient = null;

var currPoints = [];

var w, h;

var chatRoomId;

var canvas, context, flag = false,
    prevX = 0,
    currX = 0,
    prevY = 0,
    currY = 0,
    dot_flag = false;

var strokeStyle = "black",
    lineWidth = 2;

function addClick(px, py, x, y) {

    currPoints.push({'prevX': px, 'prevY': py, 'x': x, 'y': y});
};


$(document).ready(function () {

    connect();

    setUpCanvas();
});

function setUpCanvas() {

    canvas = document.getElementById('canvas');

    context = canvas.getContext("2d");
    w = canvas.width;
    h = canvas.height;

    canvas.addEventListener("mousemove", function (e) {
        findxy('move', e);
    }, false);
    canvas.addEventListener("mousedown", function (e) {
        findxy('down', e)
    }, false);
    canvas.addEventListener("mouseup", function (e) {
        findxy('up', e)
    }, false);
    canvas.addEventListener("mouseout", function (e) {
        findxy('out', e)
    }, false);
}

function draw(prevX, prevY, currX, currY) {

    context.beginPath();
    context.moveTo(prevX, prevY);
    context.lineTo(currX, currY);
    context.strokeStyle = strokeStyle;
    context.lineWidth = lineWidth;
    context.stroke();
    context.closePath();
}


function drawPoint(point) {

    draw(point.prevX, point.prevY, point.x, point.y);
}


function findxy(res, e) {

    if (res == 'down') {
        prevX = currX;
        prevY = currY;
        currX = e.clientX - canvas.offsetLeft;
        currY = e.clientY - canvas.offsetTop;

        flag = true;
        dot_flag = true;
        if (dot_flag) {
            context.beginPath();
            context.fillStyle = strokeStyle;
            context.fillRect(currX, currY, 2, 2);
            context.closePath();
            dot_flag = false;
        }
    }
    if (res == 'up' || res == "out") {
        flag = false;
        sendData();
    }
    if (res == 'move') {
        if (flag) {
            prevX = currX;
            prevY = currY;
            currX = e.clientX - canvas.offsetLeft;
            currY = e.clientY - canvas.offsetTop;
            draw(prevX, prevY, currX, currY);

            addClick(prevX, prevY, currX, currY);
        }
    }
}


function connect() {

    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);

    var urlParams = new URLSearchParams(window.location.search);
    chatRoomId = urlParams.get('room');

    stompClient.connect({'chatRoomId': chatRoomId}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/' + chatRoomId + '.public.messages', function test(points) {
            var jsonValue = JSON.parse(points.body);
            jsonValue.points.forEach(drawPoint);
        });
    }, function () {})
};



function sendData() {

    var payload = JSON.stringify({chatRoomId : chatRoomId, points: currPoints});
    stompClient.send("/app/points", {}, payload);
    currPoints = [];
};