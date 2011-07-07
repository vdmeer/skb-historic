      function divOn(sender)
      {
        var divItem  = document.getElementById('div_' + sender);
        var nextState = divItem.style.display == 'block' ? 'none' : 'block';
        divItem.style.display = nextState;
        return false;
      }
      
      function hideDiv()
      {
        var divObj = document.getElementsByTagName('div');
        for (i = 0; i < divObj.length; i++)
        {
          if(divObj[i].className == 'div_on_off')
          {
            divObj[i].style.display = 'none';
          }
  }
}
window.onload = hideDiv;
