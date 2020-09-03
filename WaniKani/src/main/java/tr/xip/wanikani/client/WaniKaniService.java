package tr.xip.wanikani.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tr.xip.wanikani.wkamodels.CriticalItemsList;
import tr.xip.wanikani.wkamodels.KanjiList;
import tr.xip.wanikani.wkamodels.LevelProgression;
import tr.xip.wanikani.wkamodels.RadicalsList;
import tr.xip.wanikani.wkamodels.RecentUnlocksList;
import tr.xip.wanikani.wkamodels.Request;
import tr.xip.wanikani.wkamodels.SRSDistribution;
import tr.xip.wanikani.wkamodels.StudyQueue;
import tr.xip.wanikani.wkamodels.User;
import tr.xip.wanikani.wkamodels.VocabularyList;

public interface WaniKaniService {

    @GET("{api_key}/user-information")
    Call<Request<User>> getUser(@Path("api_key") String api_key);

    @GET("{api_key}/study-queue")
    Call<Request<StudyQueue>> getStudyQueue(@Path("api_key") String api_key);

    @GET("{api_key}/level-progression")
    Call<Request<LevelProgression>> getLevelProgression(@Path("api_key") String api_key);

    @GET("{api_key}/srs-distribution")
    Call<Request<SRSDistribution>> getSRSDistribution(@Path("api_key") String api_key);

    @GET("{api_key}/recent-unlocks/{limit}")
    Call<Request<RecentUnlocksList>> getRecentUnlocksList(@Path("api_key") String api_key, @Path("limit") int limit);

    @GET("{api_key}/critical-items/{percentage}")
    Call<Request<CriticalItemsList>> getCriticalItemsList(@Path("api_key") String api_key, @Path("percentage") int percentage);

    @GET("{api_key}/radicals/{level}")
    Call<Request<RadicalsList>> getRadicalsList(@Path("api_key") String api_key, @Path("level") String level); // We use a string to handle the level argument as the API accepts comma-delimited level argument

    @GET("{api_key}/kanji/{level}")
    Call<Request<KanjiList>> getKanjiList(@Path("api_key") String api_key, @Path("level") String level); // We use a string to handle the level argument as the API accepts comma-delimited level argument

    @GET("{api_key}/vocabulary/{level}")
    Call<Request<VocabularyList>> getVocabularyList(@Path("api_key") String api_key, @Path("level") String level); // We use a string to handle the level argument as the API accepts comma-delimited level argument

}
