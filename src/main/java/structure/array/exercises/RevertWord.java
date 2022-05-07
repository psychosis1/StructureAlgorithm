package structure.array.exercises;

import structure.array.Stack;

public class RevertWord {
    private String word;
    private String revertWord = "";

    public RevertWord(String word) {
        this.word = word;
    }

    public String revert() {
        Stack<Character> stack = new Stack<>(Character.class, word.length());
        for (char ch : word.toCharArray()) {
            stack.push(ch);
        }

        while (!stack.isEmpty()) {
            revertWord = revertWord + stack.pop();
        }

        return revertWord;
    }
}
