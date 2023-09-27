package yandex_training_contest_backend;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DreamAboutIt {

    private Node rootNode;

    public DreamAboutIt() {
        rootNode = null;
    }

    public static void main(String[] args) {
        String s;
        List<String> dataList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            while ((s = br.readLine()) != null) {
                dataList.add(s);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        List<String> result = mailLogic(dataList);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            for (String index : result) {
                bw.write(index + " ");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<String> mailLogic(List<String> listInput) {
        //parse entry data
        String[] firthLineArrayStr = listInput.get(0).split(" ");
        String[] secondLineArrayStr = listInput.get(1).split(" ");
        int N = Integer.parseInt(firthLineArrayStr[0]); //number of head
        int Q = Integer.parseInt(firthLineArrayStr[1]); //number of changes
        List<Integer> numberHeadToChange = Arrays.stream(secondLineArrayStr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //generate tree node
        DreamAboutIt tree = new DreamAboutIt();
        tree.breadthFirstInsert(N);

        //swap element on tree node
        for (Integer integer : numberHeadToChange) {
            tree.swapFun(integer);
        }


        return new ArrayList<>();
    }


    private void swapFun(int numberOfPeek) {
        Node searchNode = null;
        Node priveosNode = null;

        Stack<Node> stack = new Stack<>();
        stack.push(rootNode);

        //find node and father node
        while (!stack.empty()) {
            Node current = stack.pop();
            if (current != null) {
                if ((current.leftNode != null) && (current.leftNode.value == numberOfPeek)) {
                    Node temp = current.leftNode;
                    current.leftNode = current;
                    current = temp;

//                    searchNode = current.leftNode;
//                    priveosNode = current;
                    break;
                } else if ((current.rightNode != null) && (current.rightNode.value == numberOfPeek)) {
//                    Node temp = current.rightNode;
//                    current.rightNode = current;
//                    current = temp;

                    Node temp = current;
                    current = current.rightNode;
                    current.rightNode = temp;


//                    searchNode = current.rightNode;
//                    priveosNode = current;
                    break;
                }
                stack.push(current.leftNode);
                stack.push(current.rightNode);

            }
        }



    }


    private void breadthFirstInsert(int treeLength) {
        Queue<Node> queue = new LinkedList<>();
        rootNode = new Node(1);
        queue.add(rootNode);

        for (int i = 2; i <= treeLength; i++) {
            Node current = queue.peek();
            if (current.leftNode == null) {
                current.leftNode = new Node(i);
                queue.add(current.leftNode);
            } else if (current.rightNode == null) {
                current.rightNode = new Node(i);
                queue.add(current.rightNode);
                queue.poll();
            }
        }
    }

    private static class Node {
        int value;
        Node leftNode;
        Node rightNode;

        public Node(int value, Node leftNode, Node rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public Node(int value) {
            this.value = value;
            this.leftNode = null;
            this.rightNode = null;
        }
    }
}
