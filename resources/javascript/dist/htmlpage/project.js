      function togglePrj(sender)
      {
        var prjItem  = document.getElementById('prj_' + sender);
        var nextState = prjItem.style.display == 'block' ? 'none' : 'block';
        //hidePrj();
        prjItem.style.display = nextState;
        return false;
      }
      
      function hidePrj()
      {
        var divObj = document.getElementsByTagName('div');
        for (i = 0; i < divObj.length; i++)
        {
          if(divObj[i].className == 'prj')
          {
            divObj[i].style.display = 'none';
          }
  }
}
window.onload = hidePrj;
