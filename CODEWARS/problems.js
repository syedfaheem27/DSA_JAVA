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

// #4. Write a function that removes the spaces from the string, then return the resultant string.

// Examples (Input -> Output):
// "8 j 8   mBliB8g  imjB8B8  jl  B" -> "8j8mBliB8gimjB8B8jlB"
// "8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd" -> "88Bifk8hB8BB8BBBB888chl8BhBfd"
// "8aaaaa dddd r     " -> "8aaaaaddddr"

function noSpace(x) {
  return x.split(" ").join("");
}

// console.log(noSpace("r retrt r ret rat er erter"));

//#5. Your task is to make two functions ( max and min, or maximum and minimum, etc., depending on the language ) that receive a list of integers as input, and return the largest and lowest number in that list, respectively. Each function returns one number.

// Examples (Input -> Output)
// * [4,6,2,1,9,63,-134,566]         -> max = 566, min = -134
// * [-52, 56, 30, 29, -54, 0, -110] -> min = -110, max = 56
// * [42, 54, 65, 87, 0]             -> min = 0, max = 87
// * [5]                             -> min = 5, max = 5

var min = function (list) {
  return list[0];
};

var max1 = function (list) {
  let maxVal = list[0];
  for (let i = 1; i < list.length; i++) {
    if (list[i] > maxVal) {
      maxVal = list[i];
    }
  }
  return maxVal;
};

var min = function (list) {
  let minVal = list[0];
  for (let i = 1; i < list.length; i++) {
    if (list[i] < minVal) {
      minVal = list[i];
    }
  }
  return minVal;
};

const max2 = (list) => Math.max(...list);

// console.log(min([0, 5, -1, 3, 4, 2, 5, 6, 7, 57, 3, 32]));

// #6. Create a function that accepts a string and a single character, and returns an integer of the count of occurrences the 2nd argument is found in the first one.

// If no occurrences can be found, a count of 0 should be returned.

// ("Hello", 'o')  =>  1
// ("Hello", 'l')  =>  2
// ("", 'z')       =>  0

function strCount(str, letter) {
  let strCount = 0;
  for (let i = 0; i < str.length; i++) {
    if (str[i] == letter) {
      strCount++;
    }
  }
  return strCount;
}

// console.log(strCount2("hello", "h"));

// #7. Return the number (count) of vowels in the given string.

// We will consider a, e, i, o, u as vowels for this Kata (but not y).
// The input string will only consist of lower case letters and/or spaces.

const vowelCount = (str) => {
  let vowelCount = 0;
  let vowels = ["a", "e", "i", "o", "u"];
  for (let i = 0; i < str.length; i++) {
    if (vowels.includes(str[i].toLowerCase())) {
      vowelCount++;
    }
  }
  return vowelCount;
};

console.log(vowelCount("hellO"));
