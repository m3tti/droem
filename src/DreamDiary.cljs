(ns DreamDiary
  (:require
   ["react-native" :refer [Text View StyleSheet Button StatusBar]]))

(def styles (StyleSheet.create
             {:container {:flex 1
                          :backgroundColor "#2d2d2d"
                          :alignItems "center"
                          :justifyContent "center"}}))

(defn Edit [{:keys [state updateState]}]
  #jsx [View {:style styles.container}
        [Text {:style {:color "#ffffff"}} "Edit"]
        [Button {:onPress #(setState {:route :dd-index})
                 :title "Test"}]
        [StatusBar {:style "auto"}]])

(defn- add-element [updateState state]
  (let [current-items (:dream-diary state)
        current-id (count current-items)]
    (prn state)
    (updateState
     {:dream-diary
      (concat [{:title (str "wurst" current-id)
                :id current-id}]
              current-items)})))

(defn- render-item [entry]
  #jsx [Text {:key (:id entry)} (:title entry)])

(defn Index [{:keys [state updateState]}]
  #jsx [View {:style styles.container}
        [Text {:style {:color "#ffffff"}} "Droem - DreamDiaryView 2.0"]
        (map render-item (:dream-diary state))
        [Button {:onPress #(add-element updateState state)
                 :title "Add Element"}]
        [StatusBar {:style "auto"}]])
