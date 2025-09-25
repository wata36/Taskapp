# タスク管理アプリ

Java/JSPを使って、ログイン機能とタスクのCRUD操作（作成・読み込み・削除）を学習するために制作したアプリケーションです。

---

## 🚀 アプリの機能と現在の状況

### 機能

現在、DBからのログイン機能実装しました。
タスクとしての追加機能、削除機能、タスク一覧未実装。
タスク完了についてはjspのみの記述です。

| 機能 | 状況 | 詳細 |
| :--- | :--- | :--- |
| **ログイン機能** | **完了** | MySQLのusers テーブルと連携したユーザー認証ロジックを実装済み。 |
| **タスク追加 (Create)** | **実装中** | DBに登録する処理は書いていますが、処理完了後、正しい一覧画面への遷移設定が未完了なため、現在はログイン画面に戻ります。 |
| **タスク一覧 (Read)** | **未着手** | DBからタスクを取得・表示するロジック（findAll）がきちんと実装できていない。 |
| **タスク削除 (Delete)** | **未着手** | サーブレットでの呼び出しロジックはありますが、DAO/Service層のDB連携処理は未実装です。 |
| **タスク完了 (Update)** | **jspのみ** | データベースの更新ロジックは未実装。 |

＊三層構造：DAO (DB)、Service (ビジネスロジック)、Servlet (制御)、JSP (画面) の役割分担で作成しています。|

### 今後の展望

１.  正しい画面の遷移タスク追加、削除のServlet画面遷移やDBへの情報格納を完成させる。
２.  機能の追加（より便利なものに）タスク完了ステータスをDBに保存する、タスク編集機能を実装する。
３.  パスワードの**ハッシュ化**など、セキュリティ強化を行う。

---

## 🛠️ 技術スタック

* **言語**: Java 2025
* **Webフレームワーク**: Servlet/JSP
* **データベース**: MySQL
* **Webサーバー**: Apache Tomcat
* **環境**: Eclipse (macOS / Intel Core i5)

---

## 💡 動作確認手順

### 1. データベース設定

MySQLで以下のSQLを実行し、データベースとテーブルを作成してください。

```sql
-- データベース作成
CREATE DATABASE task_app_db;

-- usersテーブル作成
CREATE TABLE task_app_db.users (
  user_id INT PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(50) NOT NULL
);

-- tasksテーブル作成
CREATE TABLE task_app_db.tasks (
  task_id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  tasks VARCHAR(50) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- テストアカウントの挿入
INSERT INTO task_app_db.users (user_name, password) VALUES ('testuser', 'password123');
