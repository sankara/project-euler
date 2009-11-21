(ns euler.36-binary-decimal-palindrome)

(defn palin? [n]
    (= (reverse (reverse (str n))) (reverse (str n))))

(defn to-binary [n]
    (if (= n 1) 1
        (str (to-binary (int (/ n 2))) (mod n 2))))

(defn palin-10-2 [n]
    (filter (complement nil?)
        (for [i (range 1 (inc n))]
            (if (and (palin? i) (palin? (to-binary i))) i))))

(println (time (reduce + (palin-10-2 1000001))))

;"Elapsed time: 7048.221377 msecs"
;872187
