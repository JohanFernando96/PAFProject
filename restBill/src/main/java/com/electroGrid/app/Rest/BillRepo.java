package com.electroGrid.app.Rest;
import com.electroGrid.app.Rest.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bill , Long> {

}
