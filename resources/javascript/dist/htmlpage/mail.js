function text2(domain, year, name) {
  return name + '@' + domain;
}

function textclick(e) {
  document.location = 'mailto:' + e;
}

function textview(e) {
  self.status = 'mailto:' + e;
  return true;
}

function textclear() {
  self.status = '';
  return true;
}
