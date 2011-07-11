function Go(x) {
  if(x == "nothing") {
    document.forms[0].reset();
    document.forms[0].elements[0].blur();
    return;
  }
  else {
    this.location.href = x;
    document.forms[0].reset();
    document.forms[0].elements[0].blur();
  }
}
