function word_guesser(){
  var dictionary = ["Sit down and stay a while.","Hello World!","I love Programming!","CSS","HTML","Javascript","Python","Java","Cloud Programming","many-to-many","many-to-one","one-to-one","none-the-less","Grand-father","Grand-mother","Puppy","Kitten","Cat","Dog","Stir Fry","Butter","Fox"];
  var word;
  var guessed = [""];
  var guessedLetters = [""];
  word = dictionary[Math.floor((Math.random() * 22))].split("");
  
  for(var i = 0; i < word.length; i = i + 1){
    if(word[i] != "!" && word[i] != "." && word[i] != "&" && word[i] != "?" && word[i] != " " && word[i] != "-")
      guessed[i] = "_";
    else
      guessed[i] = word[i];
  }

  var winnings = 0;

  while(arrayToString(guessed) != arrayToString(word)){
    console.log(arrayToString(guessed));
    var char = prompt("Guess a letter::");
    var charMulti=0;
    if(!beenGuessed(char, guessedLetters)){
      guessedLetters.push(char);
      for(var i = 0; i < word.length; i = i + 1){
        if(char.toUpperCase() == word[i].toUpperCase()){
          guessed[i] = word[i];
          charMulti++;
        }
      }
      winnings += fortune(charMulti);
    }
    else
      console.log("You've already guessed " +char+"!");
    console.log("Your current winnings are " +winnings+ "!");
  }
  console.log(arrayToString(guessed));
  console.log("YOU GOT THE WORD!");
  console.log("Your final winnings are " +winnings+ "!!!");
}

function arrayToString(arr){
  var string = "";
  for(var i = 0; i < arr.length; i = i + 1)
    string += arr[i];
  return string;
}

function beenGuessed(char, guessedLetters){
  for(var i = 0; i < guessedLetters.length; i++){
    if(char.toUpperCase() == guessedLetters[i].toUpperCase())
      return true;
  }
  return false;
}

function fortune(multi){
  if(multi > 0)
    return Math.floor(Math.random() * 100) * 10 * multi;
  else{
    console.log("That was an incorrect guess!");
    return -1 * Math.floor(Math.random() * 100) * 10;
  }
}

word_guesser();