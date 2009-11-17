(ns euler.21-amicable-nos)

(def sum-map (ref '{}))

(defn sum-proper [n]
    (let [sn (int (. Math sqrt n))]
        (reduce #(+ %1 %2 (/ n %2)) (filter #(zero? (mod n %)) (range 1 (inc sn))))))

(doall (for [i (range 2 10001)] (dosync (alter sum-map conj {i (sum-proper i)}))))

(println (time
    (reduce + (filter (complement nil?)
        (for [i (keys @sum-map)]
            (let [val (get @sum-map i)
                  pair-val (if (contains? @sum-map val) (get @sum-map val))]
                (if (and (= i pair-val) (not (= i val))) i)))))))

;"Elapsed time: 392.950102 msecs"
;31626

;Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
;If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair and each of a and b are called amicable numbers.
;
;For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
;The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
;
;Evaluate the sum of all the amicable numbers under 10000.
