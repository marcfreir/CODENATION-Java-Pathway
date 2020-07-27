package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CandidateID implements Serializable {

    @ManyToOne
    private User user;

    @ManyToOne
    private Acceleration acceleration;

    @ManyToOne
    private Company company;

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof CandidateID))
        {
            return false;
        }

        CandidateID candidateID = (CandidateID) object;

        if (!Objects.equals(user, candidateID.user))
        {
            return false;
        }

        if (!Objects.equals(acceleration, candidateID.acceleration))
        {
            return false;
        }
        return (Objects.equals(company, candidateID.company));
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }
}
