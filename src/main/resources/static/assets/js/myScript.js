function openNav() {
  document.getElementById("my-side-menu").style.width = "20vw";
  document.getElementById("main").style.width = "80vw";
  document.getElementById("my-header").style.width = "80vw";
  document.getElementById("my-footer").style.width = "80vw";
}

function closeNav() {
  document.getElementById("my-side-menu").style.width = "0";
  document.getElementById("main").style.width = "100vw";
  document.getElementById("my-header").style.width = "100vw";
  document.getElementById("my-footer").style.width = "100vw";
}
