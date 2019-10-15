(ns notebook)

(defrecord Note [body tags date-created location parsed-date])

(defn get-month [my-month]
    (def months {"01" "January" "02" "February" "03" "March" "04" "April" "05" "May" "06" "June" 
                 "07" "July" "08" "August" "09" "September" "10" "October" "11" "November" "12" "December"})
        (months my-month))

(defn parse-date [date-string]
    (def day (subs date-string 6 8))
    (def month (subs date-string 4 6))
    (def year (subs date-string 0 4))
    (def result-dict {:month (get-month month) :day day :year year})
    (def result-string (str (get-month month) " " day "th " year))
    [result-string result-dict]
    )

(defn build-note [body-text tags date-created location]
    (def parsed-date (parse-date date-created))
    (->Note body-text tags date-created location parsed-date))

(def my-note (build-note "Today cool things happened..." ["dagbog" "oktober"] "20191015" "Lejligheden, DK"))


(defn main [body tags date-created location]
    (build-note body tags date-created location)
)
