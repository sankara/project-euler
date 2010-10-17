(ns euler.problem-4)
(println (time
  (let [input (range 900 1000)]
    (reduce max (filter #(= (str %) (apply str (reverse (str %))))
      (for [r input r1 input] (* r r1)))))))
