(ns euler.clj)

(defn pos-int? [n]
    (and
        (= n (int n))
        (> n 0)))

(defn solve-quad [a b c] [
    (/ (+ (- b) (Math/sqrt (- (* b b) (* 4 a c)))) (* 2 a))
    (/ (- (- b) (Math/sqrt (- (* b b) (* 4 a c)))) (* 2 a))])

(defn get-positive-root [sol-set]
    (let [soln (first (filter pos-int? sol-set))]
        (if (not (nil? soln)) (int soln) nil)))

(defn triangle [n]
    (* n (inc n) 1/2))

(defn main [start]
    (loop [n start]
        (let [tn (triangle n)
              soln (get-positive-root (solve-quad 3 -1 (* -2 tn)))]
            (if (not (nil? soln))
                tn
                (recur (+ n 2)))))) ; Hn = Tn for odd(n)

(println (time (main 287)))

;"Elapsed time: 1266.241246 msecs"
;1533776805
