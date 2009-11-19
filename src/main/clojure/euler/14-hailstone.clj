(ns euler.14-hailstone)

; Creates a lazy sequence of hailstone numbers.
; Not being used. Just to try it out.
(defn hailstone-seq [seed]
    (lazy-seq (cons seed
        (if (= seed 1) '()
            (hailstone-seq (if (even? seed) (int (/ seed 2)) (+ (* 3 seed) 1)))))))

(defn find-length [seed]
    (loop [n seed count 0]
        (if (= n 1) (inc count)
            (recur (if (even? n) (/ n 2) (+ (* 3 n) 1)) (inc count)))))

(defn find-longest-hailstone-seed [start upto]
    (loop [n start max-n 1 max-length 0]
        (let [length (find-length n)
              new-max-n (if (> length max-length) n max-n)
              new-max-length (max length max-length)]
            (if (>= n upto) max-n
                (recur (+ n 1) new-max-n new-max-length)))))


(println (time (let [n 1000000 start 800000]
    (find-longest-hailstone-seed start n))))

;"Elapsed time: 4214.234317 msecs"
;837799
