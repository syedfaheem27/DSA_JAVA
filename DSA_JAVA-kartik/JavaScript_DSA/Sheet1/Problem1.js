// Brute Force for get concatination of Number Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var getConcatination = function (nums) {
  const n = nums.length; // Get the length of the nums array
  const result = new Array(2 * n); // Create a result array of size 2n

  // Copy the original nums into the first half of the result array
  for (let i = 0; i < n; i++) {
    result[i] = nums[i];
  }

  // Copy the original nums into the second half of the result array
  for (let i = 0; i < n; i++) {
    result[i + n] = nums[i];
  }

  return result;
};

// Time Complexity: O(n) - We loop through the array twice, each taking O(n) time.
// Space Complexity: O(n) - We are creating a new array of size 2n.

// 2)optimal solution for get concatination of Number Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var getConcatination = function (nums) {
  return [...nums, ...nums]; // Concatenate the array with itself using spread operator
};

// Time Complexity: O(n) - We concatenate the arrays, which takes linear time.
// Space Complexity: O(n) - We are creating a new array that contains 2n elements.

//3)Most Optimal Solution for get concatination of Number Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

/**
 * @param {number[]} nums
 * @return {number[]}
 */
function addNumbersToArray(nums) {
  var ansArray = [];
  let timeOfExecution = 2; // Dummy execution time for loop, to simulate multiple executions

  // Looping while 'timeOfExecution' is greater than 0
  while (timeOfExecution) {
    for (var i = 0; i < nums.length; i++) {
      ansArray.push(nums[i]); // Push each element of nums to the ansArray
    }
    timeOfExecution--; // Decrement the timeOfExecution
  }

  return ansArray; // Return the concatenated array
}

// Time Complexity: O(n) - The loop runs over the nums array twice, but with each iteration, it's still O(n).
// Space Complexity: O(n) - We are using the `ansArray` which can store up to 2n elements.

///////
// containsDuplicate Function

// Brute Force
var containsDuplicate = function (nums) {
  for (let i = 0; i < nums.length; i++) {
    for (let j = i + 1; j < nums.length; j++)
      if (nums[i] === nums[j]) {
        return true;
      }
  }
  return false;
};

// Optimal Solution:

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function (nums) {
  // Loop through every pair of elements
  for (let i = 0; i < nums.length; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[i] === nums[j]) {
        return true; // Found a duplicate, return true
      }
    }
  }
  return false; // No duplicates found
};

// Time Complexity: O(n^2) - We use two nested loops, so the time complexity is quadratic.
// Space Complexity: O(1) - We are not using any extra space besides the input array.

// Most Optimal Approach

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function (nums) {
  const seen = new Set(); // Initialize a set to track unique elements

  for (let num of nums) {
    if (seen.has(num)) {
      return true; // If the number is already in the set, return true (duplicate found)
    }
    seen.add(num); // Add the number to the set
  }

  return false; // No duplicates found
};

// Time Complexity: O(n) - We only loop through the array once, and checking/inserting into a set is O(1) on average.
// Space Complexity: O(n) - We are using a set to store up to n elements.

// Optimized Code

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function (nums) {
  nums.sort(); // Sort the array first (O(n log n))

  // Loop through the sorted array and check if any two consecutive elements are equal
  for (let i = 1; i < nums.length; i++) {
    if (nums[i] === nums[i - 1]) {
      return true; // Duplicate found
    }
  }

  return false; // No duplicates found
};

// Time Complexity: O(n log n) - Sorting takes O(n log n), followed by a linear scan of the array.
// Space Complexity: O(1) - Sorting the array in-place without any extra space usage.
