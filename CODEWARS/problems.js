//#1. Given a string of digits, you should replace any digit below 5 with '0' and any digit 5 and above with '1'. Return the resulting string.

// Note: input will never be an empty string

//using for loop

function fakeBin(x) {
  var newStr = "";
  for (var i = 0; i < x.length; i++) {
    if (Number(x[i]) >= 5) {
      newStr += "1";
    } else {
      newStr += "0";
    }
  }
  return newStr;
}

// using map

function fakeBin(x) {
  return x
    .split("")
    .map((n) => (n < 5 ? 0 : 1))
    .join("");
}

// console.log(fakeBin("000555111999"));

//#2. Complete the square sum function so that it squares each number passed into it and then sums the results together.

// For example, for [1, 2, 2] it should return 9 because 1square + 2square + 2square = 9

function squareSum(numbers) {
  squaredArr = numbers.map((num) => num * num);
  let sum = 0;
  for (let i = 0; i < squaredArr.length; i++) {
    sum += squaredArr[i];
  }
  return sum;
}

// could have just used either for loop or map but i forgot

function squareSumUsingMap(numbers) {
  return numbers.map((n) => n * n).reduce((a, b) => a + b, 0);
}

function squareSumsUsingForLoop(numbers) {
  let sum = 0;
  for (var i = 0; i < numbers.length; i++) {
    sum += numbers[i] ** 2;
  }
  return sum;
}

// and yeah i could hav e just done this too
const squareSumx = (numbers) => numbers.reduce((sum, n) => sum + n * n, 0);

// console.log(squareSumx([1, 2, 2]));

// #3 Complete the function that takes a non-negative integer n as input, and returns a list of all the powers of 2 with the exponent ranging from 0 to n ( inclusive ).

// Examples
// n = 0  ==> [1]        # [2^0]
// n = 1  ==> [1, 2]     # [2^0, 2^1]
// n = 2  ==> [1, 2, 4]  # [2^0, 2^1, 2^2]

function powersOfTwo(n) {
  let newArr = [];
  for (let i = 0; i <= n; i++) {
    newArr.push(2 ** i);
  }
  return newArr;
}

// console.log(powersOfTwo(2));
