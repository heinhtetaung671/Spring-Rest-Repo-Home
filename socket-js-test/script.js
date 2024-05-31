
const connectBtn = document.getElementById('connect');
const disconnectBtn = document.getElementById('disconnect');
const responseList = document.getElementById('responseList');
const sendChannel = document.getElementById('sendChannel');
const sendBtn = document.getElementById('send');

connectBtn.addEventListener('click', () => {
    const socket = new SockJS('http://localhost:8080/stomp');
    const stompClient = Stomp.over(socket);

    stompClient.connect({}, frame => {
        if(frame.command == 'CONNECTED') {
            disableConnectBtn();
            enableDisconnectBtn();
        }

    })

    document.getElementById('subscribe').addEventListener('click', () => {
        stompClient.subscribe(document.getElementById('channel').value.trim(), message => {

            const li = document.createElement('li');
            li.textContent = message.body
            responseList.appendChild(li);
        })
    })

    send.addEventListener('click', () => {
        stompClient.send(sendChannel.value, {}, JSON.stringify(document.getElementById('message').value.trim()))
    })

    disconnectBtn.addEventListener('click', () => {
        stompClient.disconnect();
        enableConnectBtn();
        disableDisconnectBtn();
    });

})


function enableConnectBtn() {
    connectBtn.disabled = false;
}

function disableConnectBtn() {
    connectBtn.disabled = true;
}

function enableDisconnectBtn() {
    disconnectBtn.disabled = false
}

function disableDisconnectBtn() {
    disconnectBtn.disabled = true
}