(ns euler.17-number-words
    (:use clojure.contrib.str-utils))

(def atoi #(Character/digit % 10))

(def num-map {
    0 "" 1 "one" 2 "two" 3 "three" 4 "four" 5 "five" 6 "six" 7 "seven" 8 "eight" 9 "nine" 10 "ten"
    11 "eleven" 12 "twelve" 13 "thirteen" 14 "fourteen" 15 "fifteen" 16 "sixteen" 17 "seventeen" 18 "eighteen" 19 "nineteen"
    20 "twenty" 30 "thirty" 40 "forty" 50 "fifty" 60 "sixty" 70 "seventy" 80 "eighty" 90 "ninety" 100 "hundred" 1000 "thousand"})

(defn get-str [num pos-val]
    (if (= pos-val 10) (get num-map (* 10 num))
        (str (if (< num 20) (get num-map num)) " " (get num-map pos-val))))

(defn in-words [n]
    (if (< n 21) (get num-map n)
        (let [n-str (str n)
              len (count n-str)
              pos-val (int (Math/pow 10 (dec len)))
              first-dig (atoi (first n-str))
              next-val (mod n pos-val)]
            (str
                (get-str first-dig pos-val)
                (if (and (not (zero? next-val)) (= pos-val 100)) " and " " ")
                (in-words next-val)))))

(def in-words-seq (for [i (iterate inc 1)] (in-words i)))

(def in-words-seq-char-count (for [i in-words-seq] (count (str (re-gsub #"[^a-z]" "" i)))))

(defn sum-in-words [max-n] (reduce + (take max-n in-words-seq-char-count)))

(println (time (sum-in-words 1000)))
;"Elapsed time: 327.395049 msecs"
;21124
