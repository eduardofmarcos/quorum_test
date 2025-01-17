package org.quorum.application;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.quorum.domain.models.BillSummary;
import org.quorum.domain.services.BillService;

/**
 * REST Controller for managing bill-related operations. Provides endpoints to fetch summaries of
 * bills.
 */
@Path("/bills")
@Produces(MediaType.TEXT_HTML)
public class BillController {

  @Inject
  BillService billService;

  @Inject
  Template bills;

  /**
   * Endpoint to fetch and display summaries of all bills.
   *
   * @return a TemplateInstance containing the summaries of bills
   */
  @GET
  @Path("/summary")
  public TemplateInstance getBillSummary() {
    List<BillSummary> billSummaries = billService.calculateBillSummaries();
    return bills.data("summaries", billSummaries);
  }
}