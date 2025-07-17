from collections import defaultdict

def load_words(file_path):
    """
    Loads words from the input file, one per line.
    Converts them to lowercase and strips whitespace.
    """
    words = []
    with open(file_path, 'r', encoding='utf-8') as f:
        for line in f:
            word = line.strip().lower()
            if word:
                words.append(word)
    return words

def group_anagrams(words):
    """
    Groups words by their sorted letter signature.
    """
    anagram_dict = defaultdict(list)
    for word in words:
        # Signature: sorted letters
        signature = ''.join(sorted(word))
        anagram_dict[signature].append(word)
    return anagram_dict

def print_anagram_groups(anagram_dict):
    """
    Prints groups of anagrams where more than 1 word shares the signature.
    """
    for group in anagram_dict.values():
        if len(group) > 1:
            # Join the words into a line
            print(' '.join(sorted(group)))

def main():
    file_path = "../words-utf8.txt"
    words = load_words(file_path)
    anagram_dict = group_anagrams(words)
    print_anagram_groups(anagram_dict)

if __name__ == "__main__":
    main()
