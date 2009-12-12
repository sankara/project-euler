(ns euler.52)

(defn digits [n] (sort (str n)))

(defn has-same-digits? [num]
    (let [str-num (digits num)]
        (and
            (= str-num (digits (* 2 num)))
            (= str-num (digits (* 3 num)))
            (= str-num (digits (* 4 num)))
            (= str-num (digits (* 5 num)))
            (= str-num (digits (* 6 num))))))

(defn main []
    (first (filter has-same-digits? (iterate inc 1))))

(println (time (main)))

;"Elapsed time: 965.122222 msecs"
;142857
