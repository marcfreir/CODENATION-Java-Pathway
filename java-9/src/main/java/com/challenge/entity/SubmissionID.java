package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SubmissionID implements Serializable {

    @ManyToOne
    private User user;

    @ManyToOne
    private Challenge challenge;

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }

        if (!(object instanceof SubmissionID))
        {
            return false;
        }

        SubmissionID submissionID = (SubmissionID) object;

        if (!Objects.equals(user, submissionID.user))
        {
            return false;
        }

        return Objects.equals(challenge, submissionID.challenge);
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }
}
