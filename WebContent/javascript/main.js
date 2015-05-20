function init(){
    var comments=document.getElementsByClassName("oneComment");
    if(comments.length > 10)
    {
        for(var i = 10;i<comments.length;i++)
        {
            comments[i].style.display="none";
        }
        var seeAll=document.getElementById("seeall");
        seeAll.style.display="block";
    }
    else
    {
        var seeAll=document.getElementById("seeall");
        seeAll.style.display="none";
    }
    var hide=document.getElementById("hide");
    hide.style.display="none";
}

function seeAllComments(){
    var comments=document.getElementsByClassName("oneComment");
    for(var i = 10;i<comments.length;i++)
    {
        comments[i].style.display="block";
    }
    var seeAll=document.getElementById("seeall");
    seeAll.style.display="none";
    var hide=document.getElementById("hide");
    hide.style.display="block";
}

function focusEmailInput(){
    var eInput=document.getElementsByName("email");
    eInput[0].style.border="3px solid lightblue";
}

function leaveEmailInput(){
    var eInput=document.getElementsByName("email");
    eInput[0].style.border="2px solid lightblue";
}

function focusTextArea(){
    var txta=document.getElementsByName("comment");
    txta[0].style.border="3px solid lightblue";
    txta[0].innerHTML="";
    var button=document.getElementsByName("submit");
    button[0].style.right="5px";
}

function leaveTextArea(){
    var txta=document.getElementsByName("comment");
    txta[0].style.border="2px solid lightblue";
    var button=document.getElementsByName("submit");
    button[0].style.right="7px";
}

function checkform(){
    var eInput=document.getElementsByName("email");
    if(eInput[0].value == "")
    {
        alert("You must input your E-mail address first!");
        return false;
    }
    var email=eInput[0].value;
    if(email.indexOf('@')==-1 || email.indexOf('@')==0 || email.indexOf('@')==email.length-1)
    {
        alert("Your email address is illegal!");
        return false;
    }
    var txta=document.getElementsByName("comment");
    if(txta[0].value == "")
    {
        alert("You've input nothing!");
        return false;
    }
    var text=txta[0].value;
    if(text.length > 900)
    {
        alert("You comment is too long!");
        return false;
    }
}
