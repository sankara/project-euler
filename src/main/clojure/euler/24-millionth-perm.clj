(ns euler.24
    (:use clojure.contrib.combinatorics))

(println (time (nth (lex-permutations '[0 1 2 3 4 5 6 7 8 9]) 999999)))

;"Elapsed time: 3318.009398 msecs"
;[2 7 8 3 9 1 5 4 6 0]
