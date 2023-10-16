import java.sql.*;

public class DB_ScoreInteract {
    // given user_id and card_id, if record doesn't exist create it. add 1 to win/loss depending, and reduce or increase score depending
    public static void addWin(String user_id, String card_id) {
        String sql = "SELECT score, wins, losses FROM scores WHERE user_ID = ? AND card_id = ?";

        try (Connection conn = DB_ConnCreator.connect();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setString(2, card_id);
            pstmt.setString(1, user_id);
            //
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // if record exists, add 1 to wins, and change score by 1
                int wins = rs.getInt("wins");
                int score = rs.getInt("score");
                wins++;
                score++;
                changeWins(user_id, card_id, wins);
                changeScore(user_id, card_id, score);
            } else {
                // if record doesn't exist, create it, add 1 to wins, and change score by 1
                createRecord(user_id, card_id);
                changeWins(user_id, card_id, 1);
                changeScore(user_id, card_id, 1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createRecord(String user_id, String card_id) {
        String sql = "INSERT INTO scores(user_ID, card_id) VALUES(?,?)";

        try (Connection conn = DB_ConnCreator.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user_id);
            pstmt.setString(2, card_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void changeWins(String user_id, String card_id, int wins) {
        String sql = "UPDATE scores SET wins = ? WHERE user_ID = ? AND card_id = ?";

        try (Connection conn = DB_ConnCreator.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, wins);
            pstmt.setString(2, user_id);
            pstmt.setString(3, card_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void changeScore(String user_id, String card_id, int score) {
        String sql = "UPDATE scores SET score = ? WHERE user_ID = ? AND card_id = ?";

        try (Connection conn = DB_ConnCreator.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, score);
            pstmt.setString(2, user_id);
            pstmt.setString(3, card_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void changeLosses(String user_id, String card_id, int losses) {
        String sql = "UPDATE scores SET losses = ? WHERE user_ID = ? AND card_id = ?";

        try (Connection conn = DB_ConnCreator.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, losses);
            pstmt.setString(2, user_id);
            pstmt.setString(3, card_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        addWin("AAAA", "john");
    }
}
