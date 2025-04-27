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

// #8. Your task is to find the first element of an array that is not consecutive.
// By not consecutive we mean not exactly 1 larger than the previous element of the array.
// E.g. If we have an array [1,2,3,4,6,7,8] then 1 then 2 then 3 then 4 are all consecutive but 6 is not, so that's the first non-consecutive number.
// If the whole array is consecutive then return null2.
// The array will always have at least 2 elements1 and all elements will be numbers. The numbers will also all be unique and in ascending order. The numbers could be positive or negative and the first non-consecutive could be either too!

function firstNonConsecutive(arr) {
  for (let i = 0; i < arr.length - 1; i++) {
    if (arr[i + 1] - arr[i] !== 1) {
      return arr[i + 1];
    }
  }
  return null;
}

// #9. Your task is to write a function which returns the n-th term of the following series, which is the sum of the first n terms of the sequence (n is the input parameter).
// Series: 1 + 1/4 + 1/7 + 1/10 + 1/13 + 1/16 + ...
// You will need to figure out the rule of the series to complete this.
// Rules:
// You need to round the answer to 2 decimal places and return it as String.
// If the given value is 0 then it should return "0.00".
// You will only be given Natural Numbers as arguments.
// Examples (Input --> Output)
// n
// 1 --> 1 --> "1.00"
// 2 --> 1 + 1/4 --> "1.25"
// 5 --> 1 + 1/4 + 1/7 + 1/10 + 1/13 --> "1.57"

function seriesSum(n) {
  let sum = 0;
  for (let i = 1; i <= n; i++) {
    sum += 1 / (1 + (i - 1) * 3);
  }
  return sum;
}
seriesSum(3);

// #9 Complete the function that accepts a string parameter, and reverses each word in the string. All spaces in the string should be retained.

// Examples
// "This is an example!" ==> "sihT si na !elpmaxe"
// "double  spaces"      ==> "elbuod  secaps"

function reverseWords(str) {
  return str
    .split(" ")
    .map((word) => word.split("").reverse().join(""))
    .join(" ");
}

// #10  Your team is writing a fancy new text editor and you've been tasked with implementing the line numbering.
// Write a function which takes a list of strings and returns each line prepended by the correct number.
// The numbering starts at 1. The format is n: string. Notice the colon and space in between.
// Examples: (Input --> Output)
// [] --> []
// ["a", "b", "c"] --> ["1: a", "2: b", "3: c"]

var number = function (array) {
  return array.map((arr, index) => `${index + 1}: ${arr}`);
};
