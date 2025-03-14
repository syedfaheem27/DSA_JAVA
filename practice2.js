function distinctNamesOptimal(ideas) {
  const map = new Map();

  for (const idea of ideas) {
    let ch = idea[0];
    let rest = idea.slice(1);

    if (map.has(ch)) {
      map.set(ch, map.get(ch).add(rest));
    } else {
      const set = new Set();
      set.add(rest);

      map.set(ch, set);
    }
  }

  const arr = map.entries().toArray();
  let totalWays=0;

  for (let i = 0; i < arr.length; i++) {
    const set = arr[i][1];

    for (let j = i + 1; j < arr.length; j++) {
      const setNew = arr[j][1];

      let notUnique = 0;

      const setIArr = set.values().toArray();

      for (let k = 0; k < setIArr.length; k++) {
        if (setNew.has(setIArr[k])) notUnique++;
      }

	  let optionsI=set.size()-notUnique;
	  let optionsII=setNew.size()-notUnique;

	  totalWays+=optionsI*optionsII*2;
    }
  }
}
