(ns DreamDiary
  (:require
   ["react-native" :refer [Text View StyleSheet Button StatusBar]]))

(def styles (StyleSheet.create
             {:container {:flex 1
                          :backgroundColor "#2d2d2d"
                          :alignItems "center"
                          :justifyContent "center"}}))

(defn Edit [{:keys [state setState]}]
  #jsx [View {:style styles.container}
        [Text {:style {:color "#ffffff"}} "Edit"]
        [Button {:onPress #(setState {:route :dd-index})
                 :title "Test"}]
        [StatusBar {:style "auto"}]])

(defn Index [{:keys [state setState]}]
  #jsx [View {:style styles.container}
        [Text {:style {:color "#ffffff"}} "Droem - DreamDiaryView 2.0"]
        [Button {:onPress #(setState {:route :dd-edit})
                 :title "Test"}]
        [StatusBar {:style "auto"}]])
