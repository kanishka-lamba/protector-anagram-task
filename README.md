# Protector – Anagram Detection Task (2025)

This repository contains my solutions to the Protector technical case assignment.  
The task was to write a program that finds all sets of words that are anagrams of each other from a list of words (1 word per line). The same logic is implemented in **Python** and **Java**.

---

## 📁 Project Structure

```
Protector/
├── README.md              ← You are here
├── words-utf8.txt         ← Input file (shared by both solutions)
│
├── python_assignment/
│   ├── main.py            ← Python implementation
│
├── java_assignment/
│   ├── AnagramFinder.java ← Java implementation
│   ├── AI_USAGE.md        ← Documentation of my ChatGPT usage
```

---

## ✅ Task Summary

**Input**: A file with one word per line  
**Output**: Groups of words that are anagrams of each other, printed one group per line.

**Example:**

```
listen silent
```

---

## 🧠 Approach & Design

### 🔹 Strategy

I used the **"canonical form" approach**:

- For each word, I **sorted its characters alphabetically** to create a unique signature (e.g., `"teak"` → `"aekt"`).
- All words with the same signature are grouped together.
- Only groups with **more than one word** are included in the output.

This method works well for detecting anagrams with **linear time grouping** and **simple sorting**.

---

### 🔹 Design Decisions

- **Data structure**: Used `defaultdict(list)` in Python and `HashMap<String, List<String>>` in Java.
- **Sorting**: Used Python's `sorted()` and Java's `Arrays.sort()` for character-level sorting.
- **File reading**: Used `readAllLines()` in Java and `open()` in Python for clean, efficient I/O.
- **Output**: Results are printed to stdout and sorted for consistent order.
- **No duplicate handling**: Input file was assumed to have unique words.

---

## ⚠️ Edge Cases Considered

- Empty lines in the input file
- Mixed-case words (all normalized to lowercase)
- Words with no anagrams (ignored in output)
- Handling file-not-found errors

---

## 🧪 How to Run

### 🐍 Python

```bash
cd python_assignment
python main.py
```

### ☕ Java

```bash
cd java_assignment
javac AnagramFinder.java
java AnagramFinder
```

> Both implementations use the file at `../words-utf8.txt`.

---

## 🤖 AI Usage

Documented in [`java_assignment/AI_USAGE.md`](java_assignment/AI_USAGE.md)

- I used ChatGPT to translate Python logic into Java by asking step-by-step questions.
- I asked for Java equivalents of specific Python functions (`defaultdict`, `sorted`, `append`, etc.).
- AI helped me think clearly about language differences, performance tradeoffs, and code design.

---

## 🙋 Contact

Prepared by: Kanishka  
Email: kanishkalamba10@gmail.com
Date: July 17, 2025
