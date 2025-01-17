package org.quorum.application;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.quorum.domain.models.LegislatorSummary;
import org.quorum.domain.services.LegislatorService;

/**
 * REST Controller for managing legislator-related operations. Provides endpoints to fetch and
 * search legislator data.
 */
@Path("/legislators")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LegislatorController {

  @Inject
  LegislatorService legislatorService;

  @Inject
  Template legislators;

  /**
   * Endpoint to display a summary of legislators.
   *
   * @return a TemplateInstance containing the summaries of legislators
   */
  @GET
  @Path("/summary")
  @Produces(MediaType.TEXT_HTML)
  public TemplateInstance getLegislatorSummary() {
    List<LegislatorSummary> summaries = legislatorService.calculateLegislatorSummaries();
    return legislators.data("summaries", summaries);
  }

  /**
   * Endpoint to search legislators by name. Returns the full list if no name is provided.
   *
   * @param name the name or partial name of the legislator to search for
   * @return a TemplateInstance containing the search results
   */
  @GET
  @Path("/search")
  @Produces(MediaType.TEXT_HTML)
  public TemplateInstance searchLegislatorsByName(@QueryParam("name") String name) {
    List<LegislatorSummary> summaries;

    if (name == null || name.trim().isEmpty()) {
      summaries = legislatorService.calculateLegislatorSummaries();
    } else {
      summaries = legislatorService.searchLegislatorsByName(name);
    }

    return legislators.data("summaries", summaries);
  }
}