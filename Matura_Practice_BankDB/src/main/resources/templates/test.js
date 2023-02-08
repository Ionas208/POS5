window.onload = () =>{
    var r1 = document.getElementById("r1");
    var r2 = document.getElementById("r2");

    onchangefunction = () =>{
        console.log("click")
    }

    r1.onchange = onchangefunction
    r2.on = onchangefunction
}