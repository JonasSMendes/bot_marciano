package botMarcioano;

import static botMarcioano.Start.scanner;

public class Bot {

    private String botname = "Marciano";
    private String keyWord;

    public Bot (){};

    public Bot(String _keyWord){
        this.keyWord = _keyWord;
    };

    public void start () {
        System.out.println("ola, sou Marciano vamos conversar?");

        String phrase = scanner.nextLine();


        while (!phrase.equals("FIM")){
            Bot bot = new Bot(phrase);


             if (!bot.useEuWord() && !bot.ckeckUpperQuestion()
                    && !bot.upperQuestion() && !bot.botQuestion()){

                 if (phrase.equals("")){
                     System.out.println("não me incomode");
                 }else {
                     System.out.println("tudo bem como quiser");
                 }

             }

            System.out.println("pode digitar estou te ouvindo amigo");
            phrase = scanner.nextLine();
        }

        System.out.println("Adeus");
    };

    public Boolean ckeckUpperQuestion (){
        boolean hasUpperCase = checkUpperCaseWord();
        boolean hasQuestionLetter = questionLetter();

        if (hasUpperCase && hasQuestionLetter) {
            System.out.println("Calma aí, eu sei o que estou fazendo.");
            return true;
        } else if (hasUpperCase) {
            return false;
        } else if (hasQuestionLetter){
            return false;
        }

        return  false;
    };

    public Boolean botQuestion(){
        String answerQuestion = "";

        if (questionLetter()){
            answerQuestion = "Certissimo";
            System.out.println(answerQuestion);
            return true;
        }

        return  false;
    }

    public Boolean upperQuestion (){
        String answerQuestion = "";

        if (checkUpperCaseWord()){
            answerQuestion = "Opa, calma ai paizão fale baixo";
            System.out.println(answerQuestion);
            return true;
        }

        return false;
    }

    public Boolean useEuWord (){
        String answerQuestion = "";

        if (euQuestion()){
            answerQuestion = "A responsabilidade é sua";
            System.out.println(answerQuestion);
            return true;
        }

        return false;
    }



    Boolean questionLetter (){
        String[] words = this.keyWord.split("\\s");

        for (String word : words) {
            for (char character : word.toCharArray()) {
                if (character == '?') {
                    return true;
                }
            }
        }

        return false;
    };

    Boolean euQuestion (){
        String[] words = this.keyWord.split("\\s");

        for(String word: words){
           if (word.contains("eu") || word.equals("eu")){
               return true;
           }
        }
        return false;
    };




    Boolean checkUpperCaseWord (){
        if (this.keyWord.isEmpty()) {
            return false;
        }

        String[] words = this.keyWord.split("\\s");

        for (String word : words) {
            boolean allUpperCase = true;
            for (char letter : word.toCharArray()) {
                if (!Character.isUpperCase(letter) && letter != '?') {
                    allUpperCase = false;
                    break;
                }
            }
            if (allUpperCase) {
                return true;
            }
        }

        return false;
    }

}
