      function toggleHelp(sender)
      {
        var helpItem  = document.getElementById('help_' + sender);
        var nextState = helpItem.style.display == 'block' ? 'none' : 'block';
        hideHelp();
        helpItem.style.display = nextState;
        return false;
      }
      
      function hideHelp()
      {
        var divObj = document.getElementsByTagName('div');
        for (i = 0; i < divObj.length; i++)
        {
          if(divObj[i].className == 'help')
          {
            divObj[i].style.display = 'none';
          }
  }
}
window.onload = hideHelp;
