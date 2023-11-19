let count = 0;
const countHeader = document.getElementById("count") // find the html element 
const countAddBtn = document.getElementById("add") // find the html element 
const countSubtractBtn = document.getElementById("subtract") // find the html element 

countHeader.innerText = count
countAddBtn.addEventListener("click", ()=> { //tell the element to listen to an event
    count++;
    countHeader.innerText = count
})

countSubtractBtn.addEventListener("click", ()=> { //tell the element to listen to an event
    count--;
    countHeader.innerText = count
})