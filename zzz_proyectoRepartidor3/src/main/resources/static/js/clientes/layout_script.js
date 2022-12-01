
window.onload = function() {
    console.log("Window loaded");
    let myButton = document.getElementById("sidebarCollapse");
    myButton.addEventListener("click", activeSidebar);
}

function activeSidebar(){
    let sidebar=document.getElementById('sidebar');
    
    if(sidebar.classList.contains("active")){
        sidebar.classList.remove("active");
    }
    else{
        sidebar.classList.add("active");
    }
}
