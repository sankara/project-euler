(ns euler.35
    (:use clojure.contrib.lazy-seqs))

(def cache (ref '{}))

(defn cache-result [perms]
    (dosync alter cache conj perms) true)

(defn rotations [n]
    (let [str-n (str n)] (vec (for [i (range 0 (count str-n))]
        (Integer/parseInt (apply str (let [parts (split-at i str-n)] (concat (last parts) (first parts)))))))))

(defn prime? [n]
    (let [sqrt-n (Math/sqrt n)]
        (not-any? zero? (map mod (repeat sqrt-n n) (range 2 sqrt-n)))))

(defn circular-prime? [n]
    (if (contains? @cache n) true
        (let [perms (rotations n) prime-perms (filter prime? perms)]
            (if (= (count perms) (count prime-perms)) (cache-result perms) false))))

(println (time (count (filter circular-prime? (take-while #(< % 1000000) primes)))))

; Quite a long run.
;"Elapsed time: 190051.393072 msecs"
;55
