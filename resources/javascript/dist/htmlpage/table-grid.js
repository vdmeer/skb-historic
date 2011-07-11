      function showContent(rowId)
      {
      	var rowC = document.getElementById(rowId + 'Content')
      	rowC.style.display = 'table-row';
      	var rowL = document.getElementById(rowId + 'Line')
      	rowL.style.display = 'none';

        var prjDiv  = document.getElementById('prj_' + rowId);
        prjDiv.style.display = 'block';

        return false;
      }

      function showLine(rowId)
      {
      	var rowC = document.getElementById(rowId + 'Content')
      	rowC.style.display = 'none';
      	var rowL = document.getElementById(rowId + 'Line')
      	rowL.style.display = 'table-row';
        return false;
      }

      function hideRow()
      {
        var rowObj = document.getElementsByTagName('tr');
        for (i = 0; i < rowObj.length; i++)
        {
          if(rowObj[i].className == 'switch')
          {
            rowObj[i].style.display = 'none';
          }
  }
}
window.onload = hideRow;
