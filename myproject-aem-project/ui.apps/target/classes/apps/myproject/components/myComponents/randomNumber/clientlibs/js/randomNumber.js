console.log(" loading random js ");
// Select DOM elements
const min = document.getElementById('min');
const max = document.getElementById('max');
const genBtn = document.getElementById('generate');
const resetBtn = document.getElementById('reset');
const randNumDisplay = document.getElementById('randomNumber');

// Function to generate a random number
function genRandNum() {

    const minVal = parseInt(min.value);
    const maxVal = parseInt(max.value);

    // Validate inputs
    /*if (isNaN(minVal) || isNaN(maxVal) || minVal <= maxVal) {
        alert("Please enter valid minimum and maximum values.");
        return;
    }*/

    // Generate a random number within the range
    const randNum = Math.floor(Math.random() * (maxVal - minVal + 1)) + minVal;
    console.log(randNum + " numver");
    randNumDisplay.textContent = randNum;
    console.log(randNum + " numver");
}

// Reset the inputs and result
function reset() {
    min.value = 1;
    max.value = 100;
    randNumDisplay.textContent = "Click the button to generate the reset naidu";
}

// Event listeners
genBtn.addEventListener('click', genRandNum);
resetBtn.addEventListener('click', reset);