(ns euler.problem-5)
(defn gcd
  ([n1 n2] (loop [a n1 b n2]
    (if (zero? a) b
      (if (zero? b) a
        (recur (- (max a b) (min a b)) (min a b)))))))

(defn gcd-n [seq] (reduce gcd seq))

(defn lcm
  ([n1 n2] (/ (* n1 n2) (gcd n1 n2))))

(defn lcm-n ([seq] (reduce lcm seq)))

(println (lcm-n '(2 4 8)))

(println (time (lcm-n (range 1 11))))

(println (time (lcm-n (range 1 21))))
