(ns euler.35
    (:use clojure.contrib.lazy-seqs))

(defn rotations [n]
    (let [str-n (str n)] (vec (for [i (range 0 (count str-n))]
        (Integer/parseInt (apply str (let [parts (split-at i str-n)] (concat (last parts) (first parts)))))))))

(defn prime? [n]
    (let [sqrt-n (Math/sqrt n)]
        (not-any? zero? (map mod (repeat sqrt-n n) (range 2 sqrt-n)))))

(defn circular-prime? [n]
    (let [perms (rotations n) prime-perms (filter prime? perms)]
        (if (= (count perms) (count prime-perms)) perms false)))

(def circular-prime? (memoize circular-prime?))
(println (time (count (filter circular-prime? (take-while #(< % 1000000) primes)))))

; Quite a long run.
;"Elapsed time: 190051.393072 msecs"
;55

;After memoization
;"Elapsed time: 253199.893399 msecs"
;55
