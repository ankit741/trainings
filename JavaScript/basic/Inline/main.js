let time = +new Date();
console.log(`script started at ${time}`);
console.log('element',document.getElementById('msg'));
while(new Date()<time+5000){
  //do nothing
}
console.log('script finished at',+new Date());