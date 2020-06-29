package Reporte;

import Estructura.ListaSimple.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

public class HuffmanEncoder {

    private static int alphabet_size = 256;

    private static void buildLookupTableImpl(Node node, String s, Map<Character, String> lookupTable) {
        if (!node.isLeaf()) {
            buildLookupTableImpl(node.leftChild, s + '0', lookupTable);
            buildLookupTableImpl(node.rightChild, s + '1', lookupTable);
        } else {
            lookupTable.put(node.character, s);
        }
    }

    public HuffmanEncoderResult compress(String data) {
        int[] freq = buildFrequencyTable(data);
        Node root = builHuffmanTree(freq);
        Map<Character, String> lookupTable = buildLookupTable(root);

        return new HuffmanEncoderResult(generateEncodedData(data, lookupTable), root);
    }

    private String generateEncodedData(String data, Map<Character, String> lookupTable) {
        StringBuilder builder = new StringBuilder();
        for (char character : data.toCharArray()) {
            builder.append(lookupTable.get(character));
        }
        return builder.toString();
    }

    private static Map<Character, String> buildLookupTable(Node root) {
        Map<Character, String> lookupTable = new HashMap<>();
        buildLookupTableImpl(root, "", lookupTable);

        return lookupTable;
    }

    private static Node builHuffmanTree(int[] freq) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (char i = 0; i < alphabet_size; i++) {
            if (freq[i] > 0) {
                priorityQueue.enqueue(new Node(i, freq[i], null, null));
            }
        }

        if (priorityQueue.getSize() == 1) {
            priorityQueue.enqueue(new Node('\0', 1, null, null));
        }

        while (priorityQueue.getSize() > 1) {
            Node left = priorityQueue.dequeue();
            Node right = priorityQueue.dequeue();
            Node parent = new Node('\0', left.frecuency + right.frecuency, left, right);
            priorityQueue.enqueue(parent);
        }

        return priorityQueue.dequeue();
    }

    private static int[] buildFrequencyTable(String data) {
        int[] freq = new int[alphabet_size];
        for (char caracter : data.toCharArray()) {
            freq[caracter]++;
        }
        return freq;
    }

    public static class Node implements Comparable<Node> {

        private char character;
        private int frecuency;
        private Node leftChild;
        private Node rightChild;

        public Node(char character, int frecuency, Node leftChild, Node rightChild) {
            this.character = character;
            this.frecuency = frecuency;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public boolean isLeaf() {
            return this.leftChild == null && this.rightChild == null;
        }

        @Override
        public int compareTo(Node o) {
            int frecuencyComparision = Integer.compare(this.frecuency, o.frecuency);
            if (frecuencyComparision != 0) {
                return frecuencyComparision;
            }
            return Integer.compare(this.character, o.character);
        }

    }

    public String decompress(HuffmanEncoderResult result) {

        StringBuilder resuBuilder = new StringBuilder();
        Node current = result.getRoot();
        int i = 0;
        while (i < result.getEncodedData().length()) {
            while (!current.isLeaf()) {
                char bit = result.getEncodedData().charAt(i);
                if (bit == '1') {
                    current = current.rightChild;
                } else if (bit == '0') {
                    current = current.leftChild;
                } else {
                    throw new IllegalArgumentException("Invalid bit in message!" + bit);
                }
                i++;
            }
            resuBuilder.append(current.character);
            current = result.getRoot();
        }

        return resuBuilder.toString();
    }

    public static class HuffmanEncoderResult {

        Node root;
        String encodedData;

        HuffmanEncoderResult(String encodedData, Node root) {
            this.encodedData = encodedData;
            this.root = root;
        }

        public Node getRoot() {
            return this.root;
        }

        public String getEncodedData() {
            return this.encodedData;
        }
    }

    public static void main(String[] args) {
        String test = "hello world!";
        HuffmanEncoder encoder = new HuffmanEncoder();
        HuffmanEncoderResult result = encoder.compress(test);
        System.out.println(result.encodedData);
        System.out.println(encoder.decompress(result));
    }
}
