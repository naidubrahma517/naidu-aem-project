console.log("naidu");

// Select DOM Elements
const track = document.querySelector('.carousel-track');
const slides = document.querySelectorAll('.carousel-slide');
const prevBtn = document.querySelector('.carousel-btn.prev');
const nextBtn = document.querySelector('.carousel-btn.next');

let currentIndex = 0;
const totalSlides = slides.length;

// Main Function to Shift Slides
function updateCarousel() {
  track.style.transform = `translateX(-${currentIndex * 100}%)`;
}

// Event Listeners for Buttons
nextBtn.addEventListener('click', () => {
  currentIndex = (currentIndex + 1) % totalSlides; // Loops back to 0
  updateCarousel();
});

prevBtn.addEventListener('click', () => {
  currentIndex = (currentIndex - 1 + totalSlides) % totalSlides; // Loops back to last
  updateCarousel();
});
let autoPlay = setInterval(() => {
  nextBtn.click();
}, 3000); // Transitions every 3 seconds

// Optional: Stop autoplay when user interacts
const container = document.querySelector('.carousel');
container.addEventListener('mouseenter', () => clearInterval(autoPlay));
container.addEventListener('mouseleave', () => {
  autoPlay = setInterval(() => { nextBtn.click(); }, 3000);
});
