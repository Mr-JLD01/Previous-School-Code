function squareNumber(num){
  var square = num*num;
  console.log("The result of squaring the number " +num+ " is "+square+".");
  return square;
}

function halfNumber(num){
  var half = num/2;
  console.log("Half of " +num+ " is "+half+".");
  return half;
}

function percentOfNumber(num1, num2){
  var percent = (num1/num2) * 100;
  console.log(num1+" is "+percent+"% of "+num2+".");
  return percent;
}

function areaOfCircle(radius){
  var area = Math.PI * squareNumber(radius);
  console.log("The area for a circle with radius "+radius+ " is " +area.toFixed(2)+".");
  return area;
}

function all(num){
  var half = halfNumber(num);
  var square = squareNumber(half);
  var area = areaOfCircle(square);
  percentOfNumber(area, squareNumber(area));
}

var num = prompt("Enter a number::");
squareNumber(num);
num = prompt("Enter a number::");
halfNumber(num);
num = prompt("Enter a number::");
var num2 = prompt("Enter a number::");
percentOfNumber(num, num2);
num = prompt("Enter a number::");
areaOfCircle(num);
num = prompt("Enter a number::");
all(num);