# タスク管理アプリ

Java/JSPを使って、ログイン機能とタスクのCRUD操作（作成・読み込み・削除）を学習するために制作したアプリケーションです。

---

## 🚀 アプリの機能と現在の状況

### 機能

現在、DBからのログイン機能実装しました。
タスクとしての追加機能、削除機能、タスク一覧未実装。
タスク完了についてはjspのみの記述です。

* **ログイン機能**: MySQLのusersテーブルに登録されたユーザー名とパスワードでログインが可能です。
* **タスク登録 (Create)**: タスクの新規作成機能の実装（ただし、現在は処理完了後にログイン画面に戻る状態）。
* **タスク削除 (Delete)**: （機能の骨組みのみ実装済み。DAO/Logicへの連携は未実装）
* **タスク完了チェック**: JSP上での見た目のみ実装済み。

* 三層構造**: 	DAO (DB接続)、service(ビジネスロジック)、Servlet (制御)、JSP (画面) という三層構造で作成しています。

| **ログイン** | **完了** | DB接続・認証ロジックは実装済み。 |
| **タスク追加 (Create)** | **実装中** | 登録処理後、正しい画面遷移（タスク一覧）への修正が必要です。 |
| **タスク一覧 (Read)** | **未着手** | DBからタスクを取得・表示するロジックは未実装。 |
| **タスク削除 (Delete)** | **未着手** | サーブレットからの削除呼び出しロジックは実装。 |
| **タスク完了 (Update)** | **未着手** | jspのみ実装 |

### 今後の展望

1.  タスク追加後の**正しい画面（タスク一覧）への遷移**を実装し、機能を完成させる。
2.  タスク一覧の**DB連携（Read）**、および**削除（Delete）**機能を完成させる。
3.  タスク完了ステータスをDBに保存する**更新（Update）**機能を実装する。
4.  パスワードの**ハッシュ化**など、セキュリティ強化を行う。

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
