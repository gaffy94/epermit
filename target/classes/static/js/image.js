const button = document.querySelector('#screenshot-button');
const img = document.querySelector('#screenshot-img');
const canvas = document.createElement('canvas');

const constraints = {
    video: true
};

const video = document.querySelector('video');
button.onclick = video.onclick = function() {
    canvas.width = 413;
    canvas.height = 531;
    canvas.getContext('2d').drawImage(video, 0, 0);
    // Other browsers will fall back to image/png
    img.src = canvas.toDataURL('image/png');
};
function handleSuccess(stream) {
    video.srcObject = stream;
}

function handleError(error) {
    console.error('Reeeejected!', error);
}

navigator.mediaDevices.getUserMedia(constraints).
then(handleSuccess).catch(handleError);